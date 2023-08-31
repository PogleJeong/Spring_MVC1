package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

/**
 * V3 는 좋은 아키텍쳐를 가지고 있지만, 개발자 입장에서는 사용하기 번거로운 작업이 많다.
 * 아무리 이론적으로 잘 설계되어 있다고 해도 개발자가 사용하는데 복잡하다면 선택하기 어려울 수 있다.
 *
 * V4 는 V3 를 조금 변형하여 개발자들이 단순하고 편리하게 사용할 수 있게 구현하였다.
 * 구조적으로는 같지만 Controller 가 ModelView 가 아니라 viewName 을 반환한다.
 */
public interface ControllerV4 {

    /**
     * @param paramMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paramMap, Map<String, Object> model);
}
