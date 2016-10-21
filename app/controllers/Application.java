package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.DiscountCoupon;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.discount;
import views.html.index;

public class Application extends Controller {

    public static Result index() {
        List<DiscountCoupon> coupons = Ebean.createQuery(DiscountCoupon.class).findList();
        return ok(index.render(coupons));
    }

    public static Result formNewCoupon() {
        Form<DiscountCoupon> form = Form.form(DiscountCoupon.class);
        return ok(discount.render(form));
    }

    public static Result newCoupon() {
        Form<DiscountCoupon> form = Form.form(DiscountCoupon.class).bindFromRequest();
        if (form.hasErrors()) {
            return badRequest(discount.render(form));
        }

        DiscountCoupon coupon = form.get();
        coupon.save();
        return redirect(routes.Application.index());
    }



}
