package com.wanghao.wiki.service;

import com.wanghao.wiki.domain.Ebook;
import com.wanghao.wiki.domain.EbookExample;
import com.wanghao.wiki.mapper.EbookMapper;
import com.wanghao.wiki.req.EbookReq;
import com.wanghao.wiki.resp.EbookResp;
import com.wanghao.wiki.util.CopyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {
    @Resource

    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        if (!ObjectUtils.isEmpty(req.getName())){
        criteria.andNameLike("%"+req.getName()+"%");
        }
        List<Ebook> ebooklist = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebooklist) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook,ebookResp);
            respList.add(ebookResp);

        }
        List<EbookResp> list = CopyUtil.copyList(ebooklist,EbookResp.class);
        return list;
    }
}
