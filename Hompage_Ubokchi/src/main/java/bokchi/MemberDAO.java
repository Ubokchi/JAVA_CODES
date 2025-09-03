package bokchi;
import java.util.List;

public interface MemberDAO {
    // 회원 가입
    int insert(MemberVO vo);
    
    // 회원 한 명 조회
    MemberVO selectByUserid(String userid);
    
    // 전체 회원 목록
    List<MemberVO> selectAll();
    
    // 회원 정보 수정
    int update(MemberVO vo);
    
    // 회원 삭제
    int delete(String userid);
}