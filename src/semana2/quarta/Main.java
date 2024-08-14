package semana2.quarta;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;
        do {

            System.out.println("1- Adicionar Livro\n" +
                    "2- Listar Livros\n" +
                    "3- Editar Livro\n" +
                    "4- Deletar um Livro\n" +
                    "5- Sair");

            int op = scanner.nextInt();
            BookDAO bookService = new BookDAO();

            List<Book> books = getBooks(bookService);

            switch (op) {
                case 1:
                    Book book = getFormBook();

                    bookService.create(book);
                    break;
                case 2:
                    listBooks(books);
                    break;
                case 3:
                    listBooks(books);

                    System.out.println("Digite o ID do livro que deseja editar: ");
                    int bookId = scanner.nextInt();
                    Book currentBook = books.stream().filter(livro -> livro.getId() == bookId).findFirst().orElse(null);


                    if (currentBook != null) {
                        System.out.println(currentBook);
                        Book bookUpdated = getFormBook();
                        currentBook.setTitle(bookUpdated.getTitle());
                        currentBook.setAuthor(bookUpdated.getAuthor());
                        currentBook.setReleaseYear(bookUpdated.getReleaseYear());


                        bookService.update(currentBook);
                    } else {
                        System.out.printf("Livro com o ID: %d não encontrado\n", bookId);
                    }

                    break;
                case 4:
                    listBooks(books);
                    System.out.println("Digite o ID do livro que deseja excluir: ");
                    int bookIdDelete = scanner.nextInt();
                    Book currentBookDelete = books.stream().filter(livro -> livro.getId() == bookIdDelete).findFirst().orElse(null);
                    if (currentBookDelete != null) {
                        bookService.delete(bookIdDelete);
                    } else {
                        System.out.printf("Livro com o ID %d não encontrado\n", bookIdDelete);

                    }
                    break;

                case 5:
                    isRunning = false;
                    ConnectionDB.closeConnection();
                    break;

            }

        } while (isRunning);
    }

    private static List<Book> getBooks(BookDAO bookService) {
        List<Book> books = bookService.readAll();
        return books;
    }

    private static void listBooks(List<Book> books) {
        System.out.println("------------------------Livros--------------------");
        for (Book livro : books) {

            System.out.println(livro.toString());

        }
        System.out.println("----------------------------------------------------");
    }

    private static Book getFormBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Título do Livro: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int releaseYear = scanner.nextInt();

        return new Book(title, author, releaseYear);
    }


}
