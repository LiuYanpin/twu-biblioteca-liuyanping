package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
/*
http://language.chinadaily.com.cn/2015-12/22/content_22771415.htm
BBC评出最经久不衰的10部经典英国小说
0001.Middlemarch (George Eliot, 1874)乔治·艾略特《米德尔马契》，1874年出版
0002.To the Lighthouse (Virginia Woolf, 1927)弗吉尼亚·伍尔芙《到灯塔去》，1927年出版
0003.Mrs Dalloway (Virginia Woolf, 1925)弗吉尼亚·伍尔芙《达洛卫夫人》，1925年出版
0004.Great Expectations (Charles Dickens, 1861)查尔斯·狄更斯《远大前程》，1861年出版
0005.Jane Eyre (Charlotte Brontë, 1847)夏洛蒂·勃朗特《简·爱》，1847年出版
0006.leak House (Charles Dickens, 1853)查尔斯·狄更斯《荒凉之屋》，1853年出版
0007.Wuthering Heights (Emily Bronte, 1847)艾米莉·勃朗特《呼啸山庄》，1847年出版
0008:David Copperfield (Charles Dickens, 1850)查尔斯·狄更斯《大卫·科波菲尔》，1850年出版
0009:Frankenstein (Mary Shelley, 1818)玛莉·雪莱《科学怪人》，1818年出版
0010:Vanity Fair (William Makepeace Thackeray, 1848)威廉·梅克皮斯·萨克雷《名利场》，1848年出版
String bookISBN, String bookName, String author, int yearPublished, int totalNumberOfTheBook
 */

public class Library {
    private HashMap<String, Book> allBooks = new HashMap<String, Book>();

    public Library() {
        initialLibrary();
    }

    private void initialLibrary() {
        Book book1 = new Book("0001", "Middlemarch", "George Eliot", 1874, 2);
        Book book2 = new Book("0002", "To the Lighthouse", "Virginia Woolf", 1927, 1);
        allBooks.put(book1.getBookISBN(), book1);
        allBooks.put(book2.getBookISBN(), book2);
    }

    public void getAllBookList() {
        String title = String.format("%-30s%-30s%-10s", "BookName", "Author", "PublishedYear");
        System.out.println(title);
        allBooks.forEach((bookISBN, oneBook) -> {
            String oneBookDetail = String.format("%-30s%-30s%-10d",
                    oneBook.getBookName(), oneBook.getAuthor(), oneBook.getYearPublished());
            System.out.println(oneBookDetail);
        });
    }

    public void getOneBookDetailByName(String bookName) {

    }
}
