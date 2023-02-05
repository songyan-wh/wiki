package com.wanghao.wiki.controller;

import com.wanghao.wiki.domain.Ebook;
import com.wanghao.wiki.service.EbookService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService;

    @GetMapping("/list")
    public List<Ebook> list(){return ebookService.list();}
}
