using Microsoft.AspNetCore.Mvc;
using MVC_Cookie.Models;

namespace MVC_Cookie.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            var CookieValue = Request.Cookies["Ukey"]?.ToString();
            ViewBag.CookieValue = CookieValue;
            return View();
        }

        public IActionResult Create()
        {
            UserLogin obj = null;
            var CookieValue = Request.Cookies["Ukey"]?.ToString();
            if (CookieValue != null)
            {
                obj = new UserLogin();
                obj.Email = CookieValue;
            }


            return View(obj);
        }
        [HttpPost]
        public IActionResult Create(UserLogin Userdata)
        {
            //ViewBag.Error = "In valid user";

            try
            { 
                if (ModelState.IsValid)
                {
                    if (Userdata.Remember == true && Userdata.Email == "training.vita@gmail.com")
                    {
                        CookieOptions options = new CookieOptions();
                        options.Expires = DateTime.Now.AddDays(7);
                        Response.Cookies.Append("Ukey", Userdata.Email, options);
                        return RedirectToAction(nameof(Index));
                    }
                    else
                    { ModelState.AddModelError("Email", "InValid data");
                        return View();
                    }
                }

               else {
                    
                    return View();

                }
            }
            catch
            {
                return View();
            }
        }
        public ActionResult Lgout()
        {
            CookieOptions options = new CookieOptions();
            options.Expires = DateTime.Now.AddDays(-1);
            Response.Cookies.Append("Ukey","", options);


            return RedirectToAction(nameof(Create));
        }

    }
}
