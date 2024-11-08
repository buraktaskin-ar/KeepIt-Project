package com.semsq.app;

import partner.Shareable;
import app.entities.BookMark;
import app.entities.User;
import bg.constants.KidFriendlyStatus;
import bg.constants.UserType;
import bg.controllers.BookMarkController;

import java.util.List;
import java.util.Scanner;

public class View {

   
    private static Scanner scanner = new Scanner(System.in);

    public static void browse(User user, List<List<BookMark>> bookMarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items.");

        int bookMarkCount = 0;

        for (List<BookMark> bookMarkList : bookMarks) {
            for (BookMark bookMark : bookMarkList) {
             
                boolean isBookMarked = getBookMarkDecision(bookMark);
                if (isBookMarked) {
                    bookMarkCount++;
                    BookMarkController.getInstance().saveUserBookMark(user, bookMark);
                    System.out.println("New item bookmarked: " + bookMark);
                }

             
                if (user.getUserType().equals(UserType.EDITOR) ||
                        user.getUserType().equals(UserType.CHIEF_EDITOR)) {
                    if (bookMark.iskidFriendlyEligible() &&
                            bookMark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookMark);
                        if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                            BookMarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookMark);
                        }
                    }
                   
                    if (bookMark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookMark instanceof Shareable) {
                        boolean isShared = getShareDecision(bookMark);
                        if (isShared) {
                            BookMarkController.getInstance().share(user, bookMark);
                        }
                    }
                }
            }
        }
    }

  
    private static boolean getBookMarkDecision(BookMark bookMark) {
        System.out.println("Do you want to bookmark this item? (yes/no): " + bookMark);
        String decision = scanner.nextLine();
        return decision.equalsIgnoreCase("yes");
    }


    private static String getKidFriendlyStatusDecision(BookMark bookMark) {
        System.out.println("Mark this item as 'approved', 'rejected', or 'unknown' for kid-friendly status: " + bookMark);
        String decision = scanner.nextLine();
        if (decision.equalsIgnoreCase("approved")) {
            return KidFriendlyStatus.APPROVED;
        } else if (decision.equalsIgnoreCase("rejected")) {
            return KidFriendlyStatus.REJECTED;
        } else {
            return KidFriendlyStatus.UNKNOWN;
        }
    }

    
    private static boolean getShareDecision(BookMark bookMark) {
        System.out.println("Do you want to share this item? (yes/no): " + bookMark);
        String decision = scanner.nextLine();
        return decision.equalsIgnoreCase("yes");
    }

}
