using Recepies.DataAbstractionLayer;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Recepies.Controllers
{
    public class LoginController : Controller
    {
        // GET: Login
        public ActionResult Index()
        {
            return View();
        }

        public string ValidateData()
        {
            string username = Request.Params["username"];
            string password = Request.Params["password"];
            DAL dal = new DAL();
            String result = dal.ValidateData(username, password);

            return result;

        }
    }
}