package practice.servlet.web.frontcontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ModelView {

    private final String viewName;

    private Map<String, Object> model = new HashMap<>();

}
