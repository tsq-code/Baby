package com.baby.web.controller.baby;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baby.common.annotation.Log;
import com.baby.common.core.controller.BaseController;
import com.baby.common.core.domain.AjaxResult;
import com.baby.common.enums.BusinessType;
import com.baby.system.domain.Baby;
import com.baby.system.service.IBabyService;
import com.baby.common.utils.poi.ExcelUtil;
import com.baby.common.core.page.TableDataInfo;

/**
 * 信息录入Controller
 * 
 * @author tsq
 * @date 2021-04-02
 */
@RestController
@RequestMapping("/system/baby")
public class BabyController extends BaseController
{
    @Autowired
    private IBabyService babyService;

    /**
     * 查询信息录入列表
     */
    @PreAuthorize("@ss.hasPermi('system:baby:list')")
    @GetMapping("/list")
    public TableDataInfo list(Baby baby)
    {
        startPage();
        List<Baby> list = babyService.selectBabyList(baby);
        return getDataTable(list);
    }

    /**
     * 导出信息录入列表
     */
    @PreAuthorize("@ss.hasPermi('system:baby:export')")
    @Log(title = "信息录入", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Baby baby)
    {
        List<Baby> list = babyService.selectBabyList(baby);
        ExcelUtil<Baby> util = new ExcelUtil<Baby>(Baby.class);
        return util.exportExcel(list, "baby");
    }

    /**
     * 获取信息录入详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:baby:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(babyService.selectBabyById(id));
    }

    /**
     * 新增信息录入
     */
    @PreAuthorize("@ss.hasPermi('system:baby:add')")
    @Log(title = "信息录入", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Baby baby)
    {
        return toAjax(babyService.insertBaby(baby));
    }

    /**
     * 修改信息录入
     */
    @PreAuthorize("@ss.hasPermi('system:baby:edit')")
    @Log(title = "信息录入", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Baby baby)
    {
        return toAjax(babyService.updateBaby(baby));
    }

    /**
     * 删除信息录入
     */
    @PreAuthorize("@ss.hasPermi('system:baby:remove')")
    @Log(title = "信息录入", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(babyService.deleteBabyByIds(ids));
    }
}
