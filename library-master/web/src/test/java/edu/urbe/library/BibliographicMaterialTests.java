/*
 * Copyright (C) Universidad Privada Dr Rafael Belloso Chacin.
 * Todos los derechos reservados.
 * La divulgación de este material está estrictamente prohibida a menos
 * que cuente con una autorización escrita por parte del propietario o
 * alguna de sus subsidiarias.
 */
package edu.urbe.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import edu.urbe.library.entity.BibliographicMaterial;
import edu.urbe.library.repository.BibliographicMaterialRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Optional;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author David Soles
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
@Profile("test")
public class BibliographicMaterialTests {

    @Autowired
    private MockMvc mockMvc;

    @Value("${library.application.token}")
    private String TOKEN;

    @MockBean
    private BibliographicMaterialRepository bibliographicMaterialRepository;

    private BibliographicMaterial bibliographicMaterial;

    @Before
    public void setUp() {
        bibliographicMaterial = new BibliographicMaterial();
        bibliographicMaterial.setIdMtb(1);
        bibliographicMaterial.setAbreviatura("PRUEBA");
        bibliographicMaterial.setDescripcionMtb("PRUEBA DE SISTEMA");
        bibliographicMaterial.setInternet("S");
        bibliographicMaterial.setImagenDefecto("/home/image");
        bibliographicMaterial.setEstado("A");
        bibliographicMaterial.setIdAcademico(1);
        bibliographicMaterial.setIdUsuario(1);
    }

    @Test
    public void whenGetBibliographicMaterial_thenReturnJsonObject() throws Exception {
        Mockito.when(bibliographicMaterialRepository.findAll()).thenReturn(java.util.Arrays.asList(bibliographicMaterial));
        System.out.println(bibliographicMaterialRepository.findAll());
        ResultActions resultActions = this.mockMvc.perform(get("/bibliography").header("Authorization", TOKEN)).andDo(print())
                .andExpect(status().isOk())
                .andDo(document("bibliography"));
        MvcResult result = resultActions.andReturn();
        String jsonString = result.getResponse().getContentAsString();
        Object dataObject = JsonPath.parse(jsonString).read("$[?(@.idMtb == 1)]");
        String dataString = dataObject.toString();
        Assert.assertThat(dataString, containsString("PRUEBA DE SISTEMA"));
    }

    @Test
    public void whenFindBibliographicMaterialById_thenReturnJsonObject() throws Exception {
        Mockito.when(bibliographicMaterialRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(bibliographicMaterial));
        this.mockMvc.perform(get("/bibliography/1").header("Authorization", TOKEN)).andDo(print())
                .andExpect(status().isOk()).andDo(document("bibliographyById"));
    }

    @Test
    public void whenPostBibliographicMaterial_thenSave_andReturnJsonObject() throws Exception {
        Mockito.when(bibliographicMaterialRepository.save(Mockito.any(BibliographicMaterial.class))).thenReturn(bibliographicMaterial);
        this.mockMvc
                .perform(post("/bibliography").header("Authorization", TOKEN).contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bibliographicMaterial)))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.descripcionMtb", is("PRUEBA DE SISTEMA"))).andDo(document("bibliographyAdd"))
                .andReturn();
    }

    @Test
    public void whenUpdateBibliographicMaterial_thenSave_andReturnJsonObject() throws Exception {
		Mockito.when(bibliographicMaterialRepository.findById(Mockito.anyInt())).thenReturn(Optional.ofNullable(bibliographicMaterial));
        Mockito.when(bibliographicMaterialRepository.update(Mockito.any(BibliographicMaterial.class))).thenReturn(bibliographicMaterial);
        this.mockMvc
                .perform(put("/bibliography/1").header("Authorization", TOKEN).contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(bibliographicMaterial)))
                .andDo(print()).andExpect(status().isOk())
                .andDo(document("bibliographyUpdate"))
                .andReturn();
    }

}
