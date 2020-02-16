package com.example.greendaodemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.greendaodemo1.beans.StudentBean;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DaoSession daoSession;
    private StudentBeanDao studentDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        daoSession = DaoManager.getInstance().getDaoSession();
        studentDao = daoSession.getStudentBeanDao();

        StudentBean student = new StudentBean();
        student.setId(0);
        student.setName("张三");
        student.setAge(10);
        student.setGender("男");
        student.setMath(59+"");
        student.setEnglish(49+"");
        studentDao.insertOrReplace(student);
        StudentBean student2 = new StudentBean();
        student2.setId(1);
        student2.setName("李四");
        student2.setAge(12);
        student2.setGender("女");
        student2.setMath(89+"");
        student2.setEnglish(98+"");
        studentDao.insertOrReplace(student2);
        //insertData(student);
        //inserOrReplace(student);
        //updateData(student);
        //deleteAll();
        //delete(student);
        queryAll();

    }

    //插入数据
    public void insertData(StudentBean student)
    {
        //daoSession.insert(student);
        studentDao.insert(student);
    }
    public void inserOrReplace(StudentBean student)
    {

        daoSession.insertOrReplace(student);
    }

    public void delete(StudentBean student)
    {
        studentDao.delete(student);
    }

    public void deleteAll()
    {
        studentDao.deleteAll();
    }

    public void updateData(StudentBean student)
    {
        studentDao.update(student);
        studentDao.updateInTx(student);
    }

    //查询数据
    public List queryAll()
    {
        List<StudentBean> students = studentDao.loadAll();
        StudentBean students2 = studentDao.load(1L);
        StudentBean students3 = studentDao.loadByRowId(0L);

        List<StudentBean> students1 = studentDao.queryBuilder().list();
        List<StudentBean> students4 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Name.eq("李四")).list();
        List<StudentBean> students5 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Name.notEq("李四")).list();
        List<StudentBean> students6 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Name.like("李%")).list();
        List<StudentBean> students7 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Age.between(0,10)).list();
        List<StudentBean> students8 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Age.gt(10)).list();
        List<StudentBean> students9 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Age.ge(10)).list();
        List<StudentBean> students10 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Age.lt(11)).list();
        List<StudentBean> students11 = studentDao.queryBuilder().where(StudentBeanDao.Properties.Age.lt(11)).list();
        List<StudentBean> students12 = studentDao.queryBuilder().orderAsc(StudentBeanDao.Properties.Age).list();
        List<StudentBean> students13 = studentDao.queryBuilder().orderDesc(StudentBeanDao.Properties.Age).list();
        Log.d("panzq","queryAll students : "+students13);
        return students;
    }

    public void queryDate(String gender)
    {
        List<StudentBean> student_gender = daoSession.queryRaw(StudentBean.class," where gender = ?",gender);
        Log.d("panzq","queryDate student_gender : "+student_gender);

    }


    
}
