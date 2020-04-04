package gta.winbo.cali;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO{

	
	@Inject
	private SqlSession S;
	
	
	@Override
	public void insert(BoardVO v) throws Exception {
	S.insert("board.insertBoard", v);
		
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		
		return S.selectOne("board.readBoard", bno);
	}

	@Override
	public List<BoardVO> showAll() throws Exception {
	
		return S.selectList("board.selectBoard");
	}

	@Override
	public void update(BoardVO v) throws Exception {
		S.update("board.updateBoard",v);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		S.delete("board.deleteBoard", bno);
		
	}

}
