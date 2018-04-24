package cn.colg.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.colg.core.BaseController;
import cn.colg.dto.Exposer;
import cn.colg.dto.SeckillExecution;
import cn.colg.entity.Seckill;
import cn.colg.result.ResultBean;
import cn.colg.result.ResultUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 商品库存 Controller <br />
 * 
 * // url：模块/资源/{id}/细分 /seckill/list
 *
 * @author colg
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController extends BaseController {

	/**
	 * 商品列表页面
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public String list(Model model) {
		// 获取列表页
		List<Seckill> list = seckillService.querySeckill();
		model.addAttribute("list", list);
		// /src/main/resources/templates/list.html
		return "list";
	}

	/**
	 * 商品秒杀详情页
	 * 
	 * @param seckillId
	 * @param model
	 * @return
	 */
	@GetMapping("/{seckillId}/detail")
	public String detail(@PathVariable(required = false) String seckillId, Model model) {
		if (StrUtil.isBlank(seckillId)) {
			// 重定向到 list
			return "redirect:/seckill/list";
		}

		Seckill seckill = seckillService.findById(seckillId);
		if (seckill == null) {
			return "forward:/seckill/list";
		}
		model.addAttribute("seckill", seckill);
		return "detail";
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 */
	@GetMapping("/time/now")
	@ResponseBody
	public ResultBean timeNow() {
		return ResultUtil.success(System.currentTimeMillis());
	}

	/**
	 * 暴露秒杀地址
	 * 
	 * @param seckillId
	 * @return
	 */
	@PostMapping("/{seckillId}/exposer")
	@ResponseBody
	public ResultBean exposer(@PathVariable String seckillId) {
		Exposer exposer = seckillService.exportSeckillUrl(seckillId);
		return ResultUtil.success(exposer);
	}

	@PostMapping("/{seckillId}/{md5}/execution")
	@ResponseBody
	public ResultBean execute(@PathVariable("seckillId") String seckillId, @PathVariable("md5") String md5,
			@CookieValue(value = "killPhone", required = false) String phone) {

		SeckillExecution seckillExecution = seckillService.executeSekill(seckillId, phone, md5);
		return ResultUtil.success(seckillExecution);
	}
}
