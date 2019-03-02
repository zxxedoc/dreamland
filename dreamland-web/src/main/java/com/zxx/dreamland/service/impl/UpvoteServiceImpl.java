package com.zxx.dreamland.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zxx.dreamland.dao.UpvoteMapper;
import com.zxx.dreamland.entity.Upvote;
import com.zxx.dreamland.service.UpvoteService;

/**
 * Created by wly on 2017/12/15.
 */
@Service
public class UpvoteServiceImpl implements UpvoteService {
    @Autowired
    private UpvoteMapper upvoteMapper;


    public Upvote findByUidAndConId(Upvote upvote) {
        return  upvoteMapper.selectOne( upvote);
    }

    public int add(Upvote upvote) {
        return upvoteMapper.insert( upvote );
    }

    public Upvote getByUid(Upvote upvote) {
        return null;
    }

    public void update(Upvote upvote) {
        upvoteMapper.updateByPrimaryKey( upvote );
    }

    @Override
    public void deleteByContentId(Long cid) {
        Upvote upvote = new Upvote();
        upvote.setContentId(cid);
        upvoteMapper.delete(upvote);
    }
}
