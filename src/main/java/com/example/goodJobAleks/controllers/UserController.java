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
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public String userPage(Model model){
        return "redirect:/user/1";
    }

    @GetMapping("/{pageNumber}")
    public String userOnSelectPage(Model model, @PathVariable("pageNumber") int currentPage,
                                   @Param("sortDir") String sortDir ){

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
    //model.addAttribute("posts",posts.stream().filter(x->x.getUser_name().equals("user@yandex.ru")));
        model.addAttribute("posts",posts);

    // Отследить количество строниц только для части элементов
        model.addAttribute("totalPage",totalPage);

    //model.addAttribute("posts",);
        return "user-main";
    }

    @GetMapping("/add")
    public String getAddPost(Model model) {

        return "user-addPost";
    }

    @PostMapping("/add")
    public String postAddPost(@RequestParam String title,
                              @RequestParam String fullText,
                              @RequestParam String user_name,
                              Model model) {
        Post post = new Post(title,fullText,user_name);
        postRepository.save(post);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String getEditPost(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/user";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "user-edit";
    }

    @PostMapping("/{id}/edit")
    public String postEditPost(@PathVariable(value = "id") long id,
                               @RequestParam String title,
                              @RequestParam String fullText,
                              @RequestParam String user_name,
                              Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(title);
        post.setFullText(fullText);
        post.setUser_name(user_name);

        postRepository.save(post);
        return "redirect:/user";
    }

    @PostMapping("/{id}/remove")
    public String postRemovePost(@PathVariable(value = "id") long id,
                               Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        postRepository.delete(post);
        return "redirect:/user";
    }

    @PostMapping("/{id}/state")
    public String postStatePost(@PathVariable(value = "id") long id,
                                 Model model) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setStatusOfPost(StatusOfPost.SEND);
        postRepository.save(post);
        return "redirect:/user";
    }

}

