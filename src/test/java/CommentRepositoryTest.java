/*
import com.web.entity.Comment;
import com.web.repo.CommentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;

public class CommentRepositoryTest {
    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    public CommentRepository commentRepository;

    @Test
    public void getByIdTask(){
       List <Comment> comments = commentRepository.getByIdComment(1);
        Iterator iter = comments.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }

}
*/