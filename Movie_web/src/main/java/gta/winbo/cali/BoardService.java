package gta.winbo.cali;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardDAO{

	
	@Inject
	private BoardDAO B;
	
	
	@Override
	public void insert(BoardVO v) throws Exception {
		B.insert(v);
		
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return B.read(bno);
	}

	@Override
	public List<BoardVO> showAll() throws Exception {
		// TODO Auto-generated method stub
		return B.showAll();
	}

	@Override
	public void update(BoardVO v) throws Exception {
		// TODO Auto-generated method stub
		B.update(v);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		// TODO Auto-generated method stub
		B.delete(bno);
		
	}

}
