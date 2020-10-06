package album.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/*AlbumDao myAlbumDao = new AlbumDao()*/

@Component("myAlbumDao")
public class AlbumDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	public int insertAlbum(AlbumBean album){
		
		//String sql = "insert into albums~";
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum",album);
		System.out.println("insertAlbum cnt : " + cnt);
		return cnt;
	}
	
	public List<AlbumBean> getAlbumList(Paging pageInfo, Map<String,String> map){
		List<AlbumBean> lists = new ArrayList<AlbumBean>(); 
		RowBounds rowbounds = new RowBounds(pageInfo.getOffset(),pageInfo.getLimit());
		//new RowBunds(0,2);
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList",map,rowbounds);
		System.out.println("list.size()"+lists.size());
		return lists; 
	}//
	
	public int deleteAlbum(int num) {
		int cnt = sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum",num);
		System.out.println("deleteAlbum cnt : " + cnt);
		return cnt;
	}
	
	public AlbumBean getOneAlbum(int num) {
		AlbumBean album = sqlSessionTemplate.selectOne("album.AlbumBean.GetOneAlbum",num);
		
		return album;
	}
	
	public int UpdateAlbum(AlbumBean album){
		
		int cnt = sqlSessionTemplate.update("album.AlbumBean.UpdateAlbum",album);
		
		return cnt;
	}
	
	public int getTotalCount(Map<String,String> map) {
		int cnt = sqlSessionTemplate.selectOne("album.AlbumBean.GetTotalCount",map);
		return cnt; 
	}
	
} 







