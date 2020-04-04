package gta.winbo.cali;

import java.util.List;

public interface BoardDAO {
	
	public void insert(BoardVO v) throws Exception;
	public BoardVO read(int bno) throws Exception;
	public List<BoardVO> showAll() throws Exception;
	public void update(BoardVO v) throws Exception;
	public void delete(int bno) throws Exception;
	
	
	

}
