package ua.profitsoft.hw5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.web.servlet.MockMvc;


@AutoConfigureMockMvc
@Sql(scripts = "classpath:test.sql", config = @SqlConfig(encoding = "UTF-8"))
public abstract class AbstractTest {
    @Autowired
    MockMvc mockMvc;
}
