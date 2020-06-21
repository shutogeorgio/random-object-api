package mvctuto.mvctuto.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordsController.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WordsControllerTests {

    @Autowired
    private MockMvc mockMvc;

    FieldDescriptor[] word = new FieldDescriptor[] {
            fieldWithPath("id").description("Id of the word"),
            fieldWithPath("name").description("Name of the word")
    };

    @Test
    public void getAllWordsShouldReturnOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/words")
                .with(user("user")))
                .andExpect(status().isOk())
                .andDo(document("get-all-words"));
    }

    @Test
    public void getSingleWordShouldReturnOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/words/{id}", 1)
                .with(user("user")))
                .andExpect(status().isOk())
                .andDo(document("get-single-word", responseFields(word)
                ));
    }
}
