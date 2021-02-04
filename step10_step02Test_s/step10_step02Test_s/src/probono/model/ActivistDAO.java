/* CREATE TABLE activist (
       activist_id          VARCHAR2(20)  PRIMARY KEY,
       name                 VARCHAR2(20) NULL,
       password             VARCHAR2(20) NULL,
       major                VARCHAR2(50) NULL
);  */
package probono.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

import probono.model.dto.ActivistDTO;
import probono.model.entity.Activist;
import probono.model.util.DBUtil;
import probono.model.util.PublicCommon;

public class ActivistDAO {

	public static boolean addActivist(ActivistDTO activist) throws SQLException{

		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			Activist newActivist = Activist.builder().
					activistId(activist.getId()).name(activist.getName()).password(activist.getPassword()).
					major(activist.getMajor()).build();
			em.persist(newActivist);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			return false;
		} finally {
			em.close();
		}
		return true;
	}

	//수정  
	//기부자 id로 주요 기부 내용 수정하기
	public static boolean updateActivist(String activistId, String newMajor) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			int result = em.createNativeQuery("update activist set major=? where activist_id=?")
					.setParameter(1, newMajor).setParameter(2, activistId).executeUpdate();

			tx.commit();
			if(result==1) {
				return true;
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return false;
	}

	//??? 삭제
	//sql - delete from activist where activist_id=?
	public static boolean deleteActivist(String activistId) throws SQLException{
		EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();

		tx.begin();
		try {
			int result = em.createNativeQuery("delete from activist where activist_id=?")
					.setParameter(1, activistId).executeUpdate();

			tx.commit();
			if(result==1) {
				return true;
			}

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;

		} finally {
			em.close();
		}
		return false;
	}


	//id로 해당 기부자의 모든 정보 반환
	public static ActivistDTO getActivist(String activistId) throws SQLException{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ActivistDTO activist = null;

		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist where activist_id=?");
			pstmt.setString(1, activistId);
			rset = pstmt.executeQuery();
			if(rset.next()){
				activist = new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		}catch(SQLException s) {
			s.printStackTrace();
			throw s;
		} finally{
			DBUtil.close(con, pstmt);
		}
		return activist;
		
		/*EntityManager em = PublicCommon.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		try {
			em.flush();
			em.clear();
//			ActivistDTO activist = (ActivistDTO)em.createNativeQuery("select * from activist where activist_id=?", Activist.class)
//					.setParameter(1, activistId).getSingleResult();
			Activist activist = (Activist)em.createNamedQuery("Activist.find").setParameter("activistId", activistId).getSingleResult();
			tx.commit();
			
			return activist;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw e;
			
		} finally {
			em.close();
		}*/
	}
		


	//???모든 기부자 검색해서 반환
	//sql - select * from activist
	public static ArrayList<ActivistDTO> getAllActivists() throws SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ActivistDTO> list = null;
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from activist");
			rset = pstmt.executeQuery();

			list = new ArrayList<ActivistDTO>();
			while(rset.next()){
				list.add(new ActivistDTO(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4)) );
			}
		}catch(SQLException s) {
			s.printStackTrace();
			throw s;
		} finally{
			DBUtil.close(con, pstmt);
		}
		return list;
	}

	//		@Test
	//		public void Test() {
	//			
	//		}
}
