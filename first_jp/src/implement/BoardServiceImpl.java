package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import first_jsp.Board;
import first_jsp.DBConn;
import first_jsp.User;
import service.BoardService;

public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> getBoardList(Board board) {

		List<Board> boardList = new ArrayList<Board>();

		try {
			Connection con = DBConn.getCon();
			String sql = "call get_board_list(?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,board.getBoardTitle());
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {

				Board board1 = new Board();
				board1.setBoardNum(rs.getInt("board_num"));
				board1.setBoardTitle(rs.getString("board_title"));
				board1.setBoardContent(rs.getString("board_content"));
				board1.setBoardWriter(rs.getString("board_writer"));
				board1.setBoardCDate(rs.getString("board_cdate"));
				board1.setBoardModifier(rs.getString("board_modifier"));
				board1.setBoardMDate(rs.getString("board_mdate"));

				boardList.add(board1);

			}
			return boardList;
			

		} catch (Exception exception) {
			exception.printStackTrace();
		}finally{
			try{
				DBConn.closeCon();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return boardList;
	}

	@Override
	public boolean doBoardWrite(Board board) {
		try {
			Connection con = DBConn.getCon();
			String sql = "call get_board_write(?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setString(3, board.getBoardWriter());
			

			int resultNum = pstmt.executeUpdate();
			if (resultNum == 1) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public Board getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doBoardDelete(Board board) {

		try {
			Connection con = DBConn.getCon();

			String sql = "delete from board where board_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNum());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean doBoardModify(Board board) {
		try {
			Connection con = DBConn.getCon();

			String sql = "update board set board_title=?, board_content=? where board_num=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoardTitle());
			pstmt.setString(2, board.getBoardContent());
			pstmt.setInt(3, board.getBoardNum());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
