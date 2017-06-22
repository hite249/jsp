package first_jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implement.BoardServiceImpl;
import service.BoardService;

public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService bs = new BoardServiceImpl();
	
	
	public String makeBoardList(String serachTitle){
		Board board = new Board();
		board.setBoardTitle(serachTitle);
		List<Board> BoardList = bs.getBoardList(board);
		String result ="";
		result += "<table border='1'>";
		result += "<tr>";
		result += "<td colspan='9' align='center'>제목 : <input type='text' name='search_title' id='search_title'/>"
				+"<input type='button' value='검색' onclick='doSearchBoard()'/></td>";
		result += "</tr>";
		result += "<tr>";
		result += "<td>No</td>";
		result += "<td>제목</td>";
		result += "<td>작성자</td>";
		result += "<td>입력일자</td>";
		result += "<td>내용</td>";
		result += "<td>수정자</td>";
		result += "<td>수정일자</td>";
		result += "<td>삭제</td>";
		result += "<td>수정</td>";
		result += "</tr>";
		
		if(BoardList.size()==0){
			result += "<tr>";
			result += "<td colspan='9' align='center'>게시물이 없습니다.</td>";
			result += "</tr>";
		}
		
		for (Board b : BoardList) {
			result += "<tr>";
			result += "<td>" + b.getBoardNum() + "</td>";
			result += "<td>" + b.getBoardTitle() + "</td>";
			result += "<td>" + b.getBoardWriter() + "</td>";
			result += "<td>" + b.getBoardCDate() + "</td>";
			result += "<td>" + b.getBoardContent() + "</td>";
			result += "<td>" + b.getBoardModifier() + "</td>";
			result += "<td>" + b.getBoardMDate() + "</td>";
			result += "<td><input type='button' value='Delete' onclick='doBoardDelete(" + b.getBoardNum()
					+ ")'/>";
			result += "<td><input type='button' value='Modify' onclick='doGoBoardModify()'/>";
			result += "</tr>";
			
			
		}
		result += "<tr>";
		result += "<td colspan='9' align ='right'><input type='button' value='Write' onclick='goWriteJsp()'/>";
		result += "</tr>";
		result += "</table border>";
		return result;
		
		
		

	}

	public void doGet(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		String action = request.getParameter("action");
		String result = "";
		String  serachTitle = request.getParameter("search_title");
		HttpSession session = request.getSession();
		if (action.equals("BOARDLIST")) {
			result +=makeBoardList(serachTitle);
				
		
			
		} else if (action.equals("DELETE")) {
			int boardAdmin = (int) session.getAttribute("board_admin");
			if (boardAdmin == 1) {
				String boardNum = request.getParameter("board_num");
				Board board = new Board();
				board.setBoardNum((Integer.parseInt(boardNum)));
				bs.doBoardDelete(board);
				result = "삭제성공";
			} else {
				result = "권한 없음";
			}
		}else if(action.equals("BOARDWRITE")){
			String boardTitle = request.getParameter("Title");
			String boardContent = request.getParameter("Content");
			
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter((String)session.getAttribute("id"));
			board.setBoardModifier((String)session.getAttribute("id"));
			
			boolean isInsert = bs.doBoardWrite(board);
			if (isInsert) {
				result += " 성공";
			} else {
				result += " 실패";

			}
			
		}else if(action.equals("BOARDMODIFY")){
			String boardTitle = request.getParameter("Title");
			String boardContent = request.getParameter("Content");
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter((String)session.getAttribute("id"));
			board.setBoardModifier((String)session.getAttribute("id"));
			
			boolean isModify = bs.doBoardModify(board);
			if (isModify) {
				result += " 성공";
			} else {
				result += " 실패";

			}
		}

		resp.setContentType("text/html; charset = UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println(result);

	}

	// BOARDLIST
	// BOARDWRITE
	// BOARDMODIFY
	// BOARDDELETE
	// BOARDVIEW
	
	
		
	

	private void makeBoardList() {
		// TODO Auto-generated method stub
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// String writeStr ="";
		//// UserController ul = new UserController(req);
		//// writeStr = ul.doAction();
		// doProcess(resp,writeStr);
	}

	public void doProcess(HttpServletResponse resp, String writeStr) throws IOException {
		// resp.setContentType("text/html; charset = UTF-8");
		//
		// PrintWriter out1 = resp.getWriter();
		// out1.println(writeStr);
	}
}
