package com.example.goodJobAleks.controllers;

import com.example.goodJobAleks.models.Post;
import com.example.goodJobAleks.models.StatusOfPost;
import com.example.goodJobAleks.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/operator")
public class OperatorController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String operatorPage(Model model){
        return "redirect:/operator/1";
    }
    @GetMapping("/{pageNumber}")
    public String operatorOnSelectPage(Model model, @PathVariable("pageNumber") int currentPage,
                                       @Param("sortDir") String sortDir){

        //String keyword = "3";

        //Сортировка по дате
        if (sortDir == null) {
            sortDir="up";
        }
        Sort sort = Sort.by("date").ascending();
        sort = sortDir.equals("up") ? sort.ascending() :sort.descending();
        model.addAttribute("sortDir",sortDir);

        String reverseSortDir = sortDir.equals("up") ? "dUp" :"up";
        model.addAttribute("reverseSortDir",reverseSortDir);


        //Поиск количества элементов
        Pageable pageable = PageRequest.of(currentPage - 1,5,sort);
        Page<Post> page = postRepository.findAll(pageable);
        //приведение к листу страниц
        List<Post> posts = postRepository.findAll(pageable).getContent();

        int totalPage = page.getTotalPages();

        //Направить в модель атрибуты выбранной страницы
        model.addAttribute("currentPage",currentPage);

        //получить от ссессии имя пользователя

        //model.addAttribute("posts",posts);

        // Отследить количество строниц только для части элементов
        model.addAttribute("totalPage",totalPage);


        //получить от ссессии имя пользователя
        //posts.stream().filter(x->x.getUser_name().equals("user@yandex.ru")
        posts.stream().forEach(x->x.setFullText(unRead(x.getFullText())));
        model.addAttribute("posts",posts.stream().filter(x->x.getStatusOfPost() == StatusOfPost.SEND));
        return "operator-main";
    }


    public String unRead(String s){
        StringBuilder newString = new StringBuilder();
        char[] arrayOfString = s.toCharArray();
        for (char one:arrayOfString){
            newString.append(one).append("-");
        }
        return newString.toString();
    }

    @PostMapping("/{id}/approved")
    public String postApprovedState(@PathVariable(value = "id") long id,
                                Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setStatusOfPost(StatusOfPost.APPROVED);
        postRepository.save(post);
        return "redirect:/operator";
    }

    @PostMapping("/{id}/rejected")
    public String postRejectedState(@PathVariable(value = "id") long id,
                                Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setStatusOfPost(StatusOfPost.REJECTED);
        postRepository.save(post);
        return "redirect:/operator";
    }


}

