package com.sven.controller;

import com.sven.model.UserArticle;
import com.sven.service.article.api.ArticleService;
import com.sven.service.article.api.dto.ArticleDTO;
import com.sven.service.user.api.UserService;
import com.sven.service.user.api.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xianglong
 */
@RestController
public class ArticleController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/{userId}/articles")
    @ResponseBody
    public WebApiResponse<List<UserArticle>> store(@PathVariable(name = "userId") Long userId) {
        //userId一般session 或者其他加密手段传过来
        UserDTO user = userService.getById(userId);
        if (user == null) {
            return WebApiResponse.error("找不到该用户");
        }
        List<ArticleDTO> articleDTOList = articleService.getByUserId(userId);
        return WebApiResponse.success(toUserArticles(user, articleDTOList));
    }

    private List<UserArticle> toUserArticles(UserDTO user, List<ArticleDTO> articleDTOList) {
        if (articleDTOList == null) {
            return Collections.emptyList();
        }
        return articleDTOList.stream().map(articleDTO -> toVo(user, articleDTO)).collect(Collectors.toList());
    }

    private UserArticle toVo(UserDTO user, ArticleDTO articleDTO) {
        UserArticle userArticle = new UserArticle();
        BeanUtils.copyProperties(articleDTO, userArticle);
        userArticle.setPhone(user.getPhone());
        userArticle.setUserName(user.getName());
        return userArticle;
    }


}
