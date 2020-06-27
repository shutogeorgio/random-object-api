package mvctuto.mvctuto.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import mvctuto.mvctuto.model.Word;
import mvctuto.mvctuto.model.WordRequest;
import mvctuto.mvctuto.repository.WordRepository;
import mvctuto.mvctuto.service.WordService;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.postgresql.hostchooser.HostRequirement.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WordsController.class)
@EntityScan(basePackageClasses = Word.class)
@ComponentScan(basePackageClasses = WordService.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class WordsControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WordService wordService;

	FieldDescriptor[] word = new FieldDescriptor[] {
			fieldWithPath("id").description("Id of the word"),
			fieldWithPath("name").description("Name of the word") };

	@BeforeClass
	public void setUp() {
	}

	@Test
	@WithMockUser(username = "user")
	public void getAllWordsShouldReturnOk() throws Exception {
		this.mockMvc.perform(get("/api/v1/words")).andExpect(status().isOk())
				.andDo(document("get-all-words"));
	}

	@Test
	@WithMockUser(username = "user")
	public void getSingleWordShouldReturnOk() throws Exception {
		long id = 1;
		Word wordObj = new Word();
		BDDMockito.given(wordService.selectSingleWord(id))
				.willReturn(Optional.of(wordObj));
		this.mockMvc.perform(get("/api/v1/words/1")).andExpect(status().isOk())
				.andDo(document("get-single-word", responseFields(word)));
	}

	@Test
	@WithMockUser(username = "user")
	public void createWordShouldReturnOk() throws Exception {
		Word word = new Word();
		word.setName("melon");

		WordRequest request = new WordRequest();
		request.setName("melon");

		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(request);

		BDDMockito.given(wordService.addWord(any())).willReturn(word);
		this.mockMvc
				.perform(post("/api/v1/words").with(csrf())
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
				.andExpect(status().isOk()).andDo(document("create-single-word"));
	}

	@Test
	@WithMockUser(username = "user")
	public void createWordShouldNotReturnOk() throws Exception {
		Word word = new Word();
		word.setName("melon");

		WordRequest request = new WordRequest();
		request.setName("");

		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(request);

		BDDMockito.given(wordService.addWord(any())).willReturn(word);
		this.mockMvc
				.perform(post("/api/v1/words").with(csrf())
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
				.andExpect(status().isNotFound());
	}

	@Test
	@WithMockUser(username = "user")
	public void updateWordShouldReturnOk() throws Exception {
		Word word = new Word();
		word.setName("google");

		WordRequest request = new WordRequest();
		request.setName("google");

		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(request);

		BDDMockito.given(wordService.updateWordById(1, request)).willReturn(true);
		this.mockMvc
				.perform(put("/api/v1/words/1").with(csrf())
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
				.andExpect(status().isOk()).andDo(document("update-single-word"));
	}

	@Test
	@WithMockUser(username = "user")
	public void updateWordShouldNotReturnOk() throws Exception {
		Word word = new Word();
		word.setName("");

		WordRequest request = new WordRequest();

		ObjectMapper mapper = new ObjectMapper();
		String content = mapper.writeValueAsString(request);

		BDDMockito.given(wordService.updateWordById(1, request)).willReturn(true);
		this.mockMvc
				.perform(put("/api/v1/words/1").with(csrf())
						.contentType(MediaType.APPLICATION_JSON_VALUE).content(content))
				.andExpect(status().isNotFound());
	}

}
