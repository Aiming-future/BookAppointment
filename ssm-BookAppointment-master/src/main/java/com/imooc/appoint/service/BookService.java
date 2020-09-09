package com.imooc.appoint.service;

import java.util.List;

import com.imooc.appoint.dto.AppointExecution;
import com.imooc.appoint.entiy.Appointment;
import com.imooc.appoint.entiy.Book;
import com.imooc.appoint.entiy.Student; 

public interface BookService {
	/**
	 * 鏌ヨ涓�鏈浘涔�
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);  
	void delById(long bookId);
	/**
	 * 鏌ヨ鎵�鏈夊浘涔�
	 * 
	 * @return
	 */
	List<Book> getList();
	/**
	 * 鐧婚檰鏃舵煡璇㈡暟鎹簱鏄惁鏈夎瀛︾敓璁板綍銆�
	 */
	Student validateStu(Long studentId,Long password);
	/**鎸夌収鍥句功鍚嶇О鏌ヨ
	 * 鎸夋潯浠舵悳绱㈠浘涔�
	 * 
	 */ 
	List<Book> getSomeList(String name);
	/*
	 * 鏌ョ湅鏌愬鐢熼绾︾殑鎵�鏈夊浘涔�
	 * 
	 */
	List<Appointment> getAppointByStu(long studentId);
	/**
	 * 棰勭害鍥句功
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appoint(long bookId, long studentId);//杩斿洖棰勭害鎴愬姛鐨勫疄浣撶被
}
