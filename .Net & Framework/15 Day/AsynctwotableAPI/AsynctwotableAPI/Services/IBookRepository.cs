using AsynctwotableAPI.Models;
using Microsoft.AspNetCore.Mvc;

namespace AsynctwotableAPI.Services
{
   
        public interface IBookRepository
        {
            Task<Book> AddAsync(Book book);
            Task<Book?> GetByIdAsync(int id);
            Task<List<Book>> GetAllAsync();
            Task<Book?> UpdateAsync(int id, Book updatedBook);
            Task<Book?> DeleteAsync(int id);
        }


    

}
