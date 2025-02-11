//package com.likebookapp.init;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//
//@Component
//public class InitService implements CommandLineRunner {
//
//    private final Map<PaperName, String> papers = Map.of(
//            PaperName.WOVE_PAPER, "Has an even texture without any particular distinguishing features.",
//            PaperName.LAID_PAPER, "When held up to the light, shows parallel lines of greater or less width running across the stamp.",
//            PaperName.GRANITE_PAPER, "Has tiny specks of coloured fibre in it, which can usually be seen with the naked eye."
//    );
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    }
//
////    @Override
////    public void run(String... args) throws Exception {
////        if (paperRepository.count() > 0) {
////            return;
////        }
////
////        papers.forEach((type, description) -> {
////            paperRepository.save(new Paper(type, description));
////        });
////    }
//}
