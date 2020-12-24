/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.gob.mingo.dircabi.sirebi.session;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author Davicho
 */
public class Session {
         private static final Logger LOGGER = LogManager.getLogger(Repositorio.class.getName());
	/*
	 * private String resource =
	 * "bo/gob/mingo/dircabi/sirebi/mybatis-config.xml"; private SqlSession
	 * session=null; public SqlSession getSession(){ try{ InputStream
	 * inputStream=Resources.getResourceAsStream(resource);
	 * 
	 * SqlSessionFactory sqlMapper=new
	 * SqlSessionFactoryBuilder().build(inputStream);
	 * session=sqlMapper.openSession(); }catch(IOException ex){
	 * ex.printStackTrace(); } return session; }
	 */
	private static SqlSessionFactory sqlSessionFactory;
       
	public static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory == null) {
			synchronized (Session.class) {
				if (sqlSessionFactory != null)
					return sqlSessionFactory;
				InputStream inputStream;
				try {
					inputStream = Resources.getResourceAsStream("META-INF/mybatis-config.xml");
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				} catch (IOException e) {
                                        LOGGER.warn("getSqlSessionFactory(); Error !!! "+ e);
				}
			}
		}
		return sqlSessionFactory;
	}
}
