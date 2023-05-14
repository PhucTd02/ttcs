package ttcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import ttcs.common.Constants;
import ttcs.model.User;
import ttcs.service.UserService;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        initDatabaseEntities();
    }


    private void initDatabaseEntities() {

        if( userService.getAllUsers().size() == 0) {
            userService.addNew(new User(" Admin", "admin", "admin", Constants.ROLE_ADMIN));
            userService.addNew(new User(" Librarian", "librarian", "librarian", Constants.ROLE_LIBRARIAN));
            userService.addNew(new User(" User", "user", "user", Constants.ROLE_USER));
        }

    }
}