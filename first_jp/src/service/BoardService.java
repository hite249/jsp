package service;

import java.util.List;

import first_jsp.Board;

public interface BoardService {
	public List<Board> getBoardList(Board board);
	public boolean doBoardWrite(Board board);
	public boolean doBoardModify(Board board);
	public boolean doBoardDelete(Board board);
	public Board getBoard();
	

}
