package org.learning.statics.dao;

import org.learning.statics.model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jieli5 on 8/21/2017.
 */
public interface ContentsDao{
    List<Contents> queryContentsByTutorialName(String tutorialName);
    int insertContentAndAttribute2CMS(List<Contents> contentList);
}
