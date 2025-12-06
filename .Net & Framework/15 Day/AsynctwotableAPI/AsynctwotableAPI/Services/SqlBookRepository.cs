using AsynctwotableAPI.Models;
using AsynctwotableAPI.Repository;
using Microsoft.EntityFrameworkCore;
using AsynctwotableAPI.Services;

namespace AsynctwotableAPI.Services
{
    public class SqlBookRepository : IBookRepository
    {
        private readonly AppdbContext _context;

        public SqlBookRepository(AppdbContext context)
        {
            _context = context;
        }

        public async Task<Book> AddAsync(Book book)
        {
            await _context.Books.AddAsync(book);
            await _context.SaveChangesAsync();
            return book;
        }

        public async Task<Book?> GetByIdAsync(int id)
        {
            return await _context.Books.FindAsync(id);
        }

        public async Task<List<Book>> GetAllAsync()
        {
            return await _context.Books.ToListAsync();
        }

        public async Task<Book?> UpdateAsync(int id, Book updatedBook)
        {
            if (id != updatedBook.BookId)
                return null;

            var existingBook = await _context.Books.FindAsync(id);
            if (existingBook == null)
                return null;

            _context.Entry(existingBook).CurrentValues.SetValues(updatedBook);
            await _context.SaveChangesAsync();
            return existingBook;
        }

        public async Task<Book?> DeleteAsync(int id)
        {
            var book = await _context.Books.FindAsync(id);
            if (book == null)
                return null;

            _context.Books.Remove(book);
            await _context.SaveChangesAsync();
            return book;
        }
    }
}
