using AsynctwotableAPI.Models;
using  AsynctwotableAPI.Services;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;

namespace AsynctwotableAPI.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class BookController : ControllerBase
    {
        private readonly IBookRepository _bookRepository;

        public BookController(IBookRepository bookRepository)
        {
            _bookRepository = bookRepository;
        }

        // GET: api/book
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Book>>> GetAllBooks()
        {
            var books = await _bookRepository.GetAllAsync();
            return Ok(books);
        }

        // GET: api/book/{id}
        [HttpGet("{id}")]
        public async Task<ActionResult<Book>> GetBookById(int id)
        {
            var book = await _bookRepository.GetByIdAsync(id);
            if (book == null)
                return NotFound();

            return Ok(book);
        }

        // POST: api/book
        [HttpPost]
        public async Task<ActionResult<Book>> AddBook(Book book)
        {
            var createdBook = await _bookRepository.AddAsync(book);
            return CreatedAtAction(nameof(GetBookById), new { id = createdBook.BookId }, createdBook);
        }

        // PUT: api/book/{id}
        [HttpPut("{id}")]
        public async Task<ActionResult<Book>> UpdateBook(int id, Book book)
        {
            var updatedBook = await _bookRepository.UpdateAsync(id, book);
            if (updatedBook == null)
                return NotFound();

            return Ok(updatedBook);
        }

        // DELETE: api/book/{id}
        [HttpDelete("{id}")]
        [Authorize]
        public async Task<ActionResult<Book>> DeleteBook(int id)
        {
            var deletedBook = await _bookRepository.DeleteAsync(id);
            if (deletedBook == null)
                return NotFound();

            return Ok(deletedBook);
        }
    }
}


