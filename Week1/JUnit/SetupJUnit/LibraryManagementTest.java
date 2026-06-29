public class LibraryManagementTest {

    static class Book {
        String title;
        String author;
        boolean isAvailable;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isAvailable = true;
        }

        void borrowBook() {
            if (isAvailable) {
                isAvailable = false;
                System.out.println("Book borrowed: " + title);
            } else {
                System.out.println("Book not available: " + title);
            }
        }

        void returnBook() {
            isAvailable = true;
            System.out.println("Book returned: " + title);
        }
    }

    static void testBookCreation() {
        Book book = new Book("Clean Code", "Robert Martin");
        assert book.title.equals("Clean Code") : "Title mismatch";
        assert book.isAvailable == true : "Book should be available";
        System.out.println("✓ testBookCreation passed");
    }

    static void testBorrowBook() {
        Book book = new Book("Clean Code", "Robert Martin");
        book.borrowBook();
        assert book.isAvailable == false : "Book should not be available after borrowing";
        System.out.println("✓ testBorrowBook passed");
    }

    static void testReturnBook() {
        Book book = new Book("Clean Code", "Robert Martin");
        book.borrowBook();
        book.returnBook();
        assert book.isAvailable == true : "Book should be available after returning";
        System.out.println("✓ testReturnBook passed");
    }

    public static void main(String[] args) {
        System.out.println("=== Running Library Management Tests ===");
        testBookCreation();
        testBorrowBook();
        testReturnBook();
        System.out.println("=== All Tests Passed ===");
    }
}