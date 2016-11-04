package controllers;

import java.util.List;

import com.avaje.ebean.Ebean;

import models.DiscountCoupon;
import play.data.Form;
import play.db.ebean.Model;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.input.DiscountInput;
import views.html.discount;
import views.html.index;

import static play.data.Form.form;

public class Application extends Controller {

    public static Result index() {
//        List<DiscountCoupon> coupons = DiscountCoupon.find()
//                .where().orderBy("id").findList();

        DiscountInput discountInput = new DiscountInput();
        discountInput.setId(10L);
        discountInput.setName("TESTANDO SAPORRA");

        return ok(Json.toJson(discountInput));
    }

    public static Result newCoupon() {
        Form<DiscountCoupon> form = form(DiscountCoupon.class);
        return ok(discount.render(form));
    }

    public static Result saveCoupon() {
        Form<DiscountCoupon> form = form(DiscountCoupon.class).bindFromRequest();
        if (form.hasErrors()) {
            flash("error", "Validation error occurred! Please, fix then.");
            return badRequest(discount.render(form));
        }
        DiscountCoupon coupon = form.get();
        if (coupon.getId() == null) {
            coupon.save();
            flash("success", "Coupon saved successfully.");
        } else {
            coupon.update();
            flash("success", "Coupon updated successfully.");
        }
        return redirect(routes.Application.index());
    }

    public static Result details(Long id) {
        Form<DiscountCoupon> formLoaded = form(DiscountCoupon.class)
                .fill(DiscountCoupon.find().byId(id));
        return ok(discount.render(formLoaded));
    }

    public static Result remove(Long id) {
        DiscountCoupon discountCoupon = DiscountCoupon.find().byId(id);
        discountCoupon.delete();
        flash("success", "Discount deleted successfully");
        return redirect(routes.Application.index());
    }
}
