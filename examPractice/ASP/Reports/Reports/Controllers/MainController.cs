using Reports.DataAbstractionlayer;
using Reports.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Script.Serialization;

namespace Reports.Controllers
{
    public class MainController : Controller
    {
        // GET: Main
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult LoginManager()
        {
            return View("LoginManager");
        }

        public ActionResult Application()
        {
            return View("Application");
        }

        public ActionResult AllReports()
        {
            return View("AllReports");
        }

        public ActionResult MyReports()
        {
            return View("MyReports");
        }

        public ActionResult ReportsCRUD()
        {
            return View("ReportsCRUD");
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
                System.IO.File.WriteAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Reports\Reports\Controllers\loggeduser.txt", lines);
            }
            return result;

        }

        public string GetAllReports()
        {
            int start = int.Parse(Request.Params["start"]);
            int end = int.Parse(Request.Params["end"]);
            DAL dal = new DAL();
            List<Report> dlist = dal.GetAllReports(start, end);

            var jsonSerialiser = new JavaScriptSerializer();
            var json = jsonSerialiser.Serialize(dlist);

            return json;
        }

        public string GetMyReports()
        {
            int start = int.Parse(Request.Params["start"]);
            int end = int.Parse(Request.Params["end"]);
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Reports\Reports\Controllers\loggeduser.txt");
            string username = lines[0];
            DAL dal = new DAL();
            List<Report> dlist = dal.GetMyReports(start, end, username);
            var jsonSerialiser = new JavaScriptSerializer();
            var json = jsonSerialiser.Serialize(dlist);

            return json;

        }

        public string AddReport()
        {
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Reports\Reports\Controllers\loggeduser.txt");
            string username = lines[0];

            string name = Request.Params["type"];
            string category = Request.Params["severity"];


            DAL dal = new DAL();
            dal.addReport(name, category, username);

            return "success";
        }

        public string DelReport()
        {
            string[] lines = System.IO.File.ReadAllLines(@"C:\Users\Catalin\Desktop\#WORK\anul2\Programare Web\Web-Programming\examPractice\ASP\Reports\Reports\Controllers\loggeduser.txt");
            string username = lines[0];

            string name = Request.Params["type"];
            string category = Request.Params["severity"];


            DAL dal = new DAL();
            dal.delReport(name, username);

            return "success";
        }
    }
}