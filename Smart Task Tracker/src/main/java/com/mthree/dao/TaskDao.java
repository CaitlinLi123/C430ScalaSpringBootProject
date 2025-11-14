package com.mthree.dao;

import com.mthree.entity.Category;
import com.mthree.entity.Task;
import com.mthree.entity.Task;

import java.util.List;
import java.util.Optional;


@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

}
