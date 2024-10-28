package javabean;
/********************
*@author created by xiaohutuxian
*@date  2019��6��8��---����6:31:28
*@IDE	eclipse
*@jdk	1.8.0_161
*********************/
import java.sql.*;

public class db_conn {
	public Connection conn = null;
	public ResultSet res = null;
	public Statement st = null;
	
	//���ݿ��ʼ������
	public  db_conn() {
		String URL="jdbc:mysql://localhost:3306/ticket?serverTimezone=UTC";
		String USER="root";
		String PWD="root";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			System.out.println(e);
		}try{
			conn = DriverManager.getConnection(URL,USER,PWD);
			st=conn.createStatement();
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
	//�����ݿ����������
	public int executeInsert(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.println("������ݳ�����Ϣ:"+e.getMessage());
		}
		return num;
	}
	
	//�����ݿ��в�ѯ����
	public ResultSet executeQuery(String sql){
		res=null;
		try{
			res=st.executeQuery(sql);
		}
		catch(SQLException e){
			System.out.print("��ѯ������Ϣ:"+e.getMessage());
		}
		return res;
	}
	
	//��������
	public int Update(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}catch(SQLException ex){
			System.out.print("ִ���޸��д���"+ex.getMessage());
		}
		return num;
	}
	
	//ɾ������
	public int executeDelete(String sql){
		int num=0;
		try{
			num=st.executeUpdate(sql);
		}
		catch(SQLException e){
			System.out.print("ִ��ɾ���д���:"+e.getMessage());
		}
		return num;
	}
	
	//�ر����ݿ�����
	public void closeDB(){
		try{
			st.close();
			conn.close();
		}
		catch(Exception e){
			System.out.print("ִ�йر�Connection�����д���:"+e.getMessage());
		}
	}
}
