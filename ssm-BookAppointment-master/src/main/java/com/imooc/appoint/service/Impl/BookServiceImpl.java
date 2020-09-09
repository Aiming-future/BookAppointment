package com.imooc.appoint.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.appoint.dao.AppointmentDao;
import com.imooc.appoint.dao.BookDao;
import com.imooc.appoint.dao.StudentDao;
import com.imooc.appoint.dto.AppointExecution;
import com.imooc.appoint.entiy.Appointment;
import com.imooc.appoint.entiy.Book;
import com.imooc.appoint.entiy.Student;
import com.imooc.appoint.enums.AppointStateEnum;
import com.imooc.appoint.exception.AppointException;
import com.imooc.appoint.exception.NoNumberException;
import com.imooc.appoint.exception.RepeatAppointException;
import com.imooc.appoint.service.BookService;
@Transactional 
@Service
public class BookServiceImpl implements BookService{
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BookDao bookDao;
	@Autowired
	private AppointmentDao appointmentDao;
	@Autowired
	private StudentDao studentDao; 
	@Override
	public Book getById(long bookId) { 
		return bookDao.queryById(bookId);
	}  
	@Override
	public List<Book> getList() { 
		return bookDao.queryAll(0, 1000);
	} 
	@Override
	public Student validateStu(Long studentId,Long password){
		return studentDao.quaryStudent(studentId, password);
	}
	@Override
	public List<Book> getSomeList(String name) {
		 
		return bookDao.querySome(name);
	} 
	@Override
	public List<Appointment> getAppointByStu(long studentId) {//DOTO
		return appointmentDao.quaryAndReturn(studentId);
		 
	}
	@Override
	@Transactional
	public AppointExecution appoint(long bookId, long studentId) {//鍦―ao鐨勫熀纭�涓婄粍缁囬�昏緫锛屽舰鎴愪笌web鎴愪氦浜掔敤鐨勬柟娉�
		try{													  //杩斿洖鎴愬姛棰勭害鐨勭被鍨嬨��		
			int update=bookDao.reduceNumber(bookId);//鍑忓簱瀛�
			if(update<=0){//宸茬粡鏃犲簱瀛橈紒
				throw new NoNumberException("no number");
			}else{
				//鎵ц棰勭害鎿嶄綔
				int insert=appointmentDao.insertAppointment(bookId, studentId);
				if(insert<=0){//閲嶅棰勭害
					throw new RepeatAppointException("repeat appoint");
				}else{//棰勭害鎴愬姛
					return new AppointExecution(bookId,AppointStateEnum.SUCCESS);
				}
				
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 鎵�鏈夌紪璇戞湡寮傚父杞崲涓鸿繍琛屾湡寮傚父
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}
	@Override
	public void delById(long bookId) {
		// TODO Auto-generated method stub
		bookDao.delBook(bookId);
	}

 
}
