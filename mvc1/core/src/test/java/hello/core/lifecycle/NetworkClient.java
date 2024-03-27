package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;  // javax -> 자바 공식 지원!
import javax.annotation.PreDestroy;

//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = "+ url);
    }

// implements InitializingBean
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메시지");
//    }
//
//    implements DisposableBean
//    @Override
//    public void destroy() throws Exception{
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() throws Exception{
        System.out.println("NetworkClient.close");
        disconnect();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message){
        System.out.println("{call : "+ url + " \nmessage  : " + message+"}");
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }
}
