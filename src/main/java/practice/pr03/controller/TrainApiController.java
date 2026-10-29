package practice.pr03.controller;

import practice.pr03.model.Train;
import practice.pr03.service.TrainService;
import tools.jackson.databind.ObjectMapper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/trains")
public class TrainApiController extends HttpServlet {

    private TrainService trainService;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(ServletConfig config) throws ServletException {
        trainService = TrainService.getInstance();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCors(resp);
        setJson(resp);

        Train train = objectMapper.readValue(req.getInputStream(), Train.class); // 요청받은 내용 확인, getInputStream() body를 받아오기 위한 통로
        trainService.register(train);
        System.out.println(train);

        String json = objectMapper.writeValueAsString(train); // json문자열로 변환
        resp.getWriter().println(json); // getWriter() body를 보내기 위한 통로
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setCors(resp);
        setJson(resp);

        List<Train> trainList = trainService.getTrainAll();
        resp.getWriter().println(objectMapper.writeValueAsString(trainList)); // 리스트를 문자열로 바꿔서 응답.
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) {
        setCors(resp);
        resp.setStatus(200);
    }

    private void setCors(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type");
    }

    private void setJson(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }

}
