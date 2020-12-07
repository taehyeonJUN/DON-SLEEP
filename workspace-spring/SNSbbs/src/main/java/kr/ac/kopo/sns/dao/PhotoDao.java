package kr.ac.kopo.sns.dao;

import java.util.List;

import kr.ac.kopo.sns.model.Photo;


public interface PhotoDao {

	void addPhoto(Photo phoVo);

	List<Photo> photoList(int postNo);

}
