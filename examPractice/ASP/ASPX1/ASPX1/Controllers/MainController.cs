using ASPX1.DataAbstractionLayer;
using ASPX1.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Script.Serialization;

namespace ASPX1.Controllers
{
    public class MainController : Controller
    {
        // GET: Main
        public ActionResult Index()
        {
            return View("Index");
        }

        public ActionResult LoginManager()
        {
            return View("Login");
        }

        public ActionResult Application()
        {
            return View("Application");
        }

        public ActionResult RecipiesManager() {
            return View("Recipies");
        }

        public ActionResult RecipiesCRUD()
        {
            return View("RecipiesCRUD");
        }

        public string ValidateData()
        {
            string username = Request.Params["username"];
            string password = Request.Params["password"];
            DAL dal = new DAL();
            String result = dal.ValidateData(username, password);
            User currentUser = dal.GetUser();
            if (currentUser != null)
            {
                String[] lines = { currentUser.username, currentUser.password };
                System.IO.File.WriteAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Recepies\Recepies\Controllers\loggeduser.txt", lines);
            }
            return result;

        }

        public string GetRecipies()
        {
            int start = int.Parse(Request.Params["start"]);
            int end = int.Parse(Request.Params["end"]);
            DAL dal = new DAL();
            List<Recipie> dlist = dal.GetRecipies(start, end);

            var jsonSerialiser = new JavaScriptSerializer();
            var json = jsonSerialiser.Serialize(dlist);

            return json;
        }

        public string AddRecipe()
        {
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Recepies\Recepies\Controllers\loggeduser.txt");
            string username = lines[0];

            string name = Request.Params["name"];
            string category = Request.Params["category"];


            DAL dal = new DAL();
            dal.addRecipe(name, category, username);

            return "success";
        }

        public string DelRecipe()
        {
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Recepies\Recepies\Controllers\loggeduser.txt");
            string username = lines[0];

            string name = Request.Params["name"];
            string category = Request.Params["category"];


            DAL dal = new DAL();
            dal.delRecipe(name, username);

            return "success";
        }
    }
}