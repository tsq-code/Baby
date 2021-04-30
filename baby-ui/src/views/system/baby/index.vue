<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择性别" clearable size="small">
          <el-option
            v-for="dict in sexOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期" prop="birth">
        <el-date-picker clearable size="small"
          v-model="queryParams.birth"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择出生日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="出生地" prop="address">
        <el-input
          v-model="queryParams.address"
          placeholder="请输入出生地"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出生孕周" prop="weekNum">
        <el-input
          v-model="queryParams.weekNum"
          placeholder="请输入出生孕周"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="健康状况" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择健康状况" clearable size="small">
          <el-option
            v-for="dict in statusOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="体重" prop="weight">
        <el-input>
          v-model="queryParams.weight"
          placeholder="请输入体重"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
		      <template slot="append">克</template>
        </el-input>
      </el-form-item>
      <el-form-item label="体长" prop="height">
        <el-input>
          v-model="queryParams.height"
          placeholder="请输入体长"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
		      <template slot="append">厘米</template>
        </el-input>
      </el-form-item>
      <el-form-item label="母亲姓名" prop="nameMother">
        <el-input
          v-model="queryParams.nameMother"
          placeholder="请输入母亲姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="ageMother">
        <el-input
          v-model="queryParams.ageMother"
          placeholder="请输入年龄"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="国籍" prop="countryMother">
        <el-input
          v-model="queryParams.countryMother"
          placeholder="请输入国籍"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idMother">
        <el-input
          v-model="queryParams.idMother"
          placeholder="请输入身份证号"
		  :maxlength="18"
		  show-word-limit
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
		  prefix-icon='el-icon-user-solid'
		  :style="{width: '100%'}"
        />
      </el-form-item>
      <el-form-item label="父亲姓名" prop="nameFather">
        <el-input
          v-model="queryParams.nameFather"
          placeholder="请输入父亲姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄" prop="ageFather">
        <el-input
          v-model="queryParams.ageFather"
          placeholder="请输入年龄"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="国籍" prop="countryFather">
        <el-input
          v-model="queryParams.countryFather"
          placeholder="请输入国籍"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="身份证号" prop="idFather">
        <el-input
          v-model="queryParams.idFather"
          placeholder="请输入身份证号"
		  :maxlength="18"
		  show-word-limit
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
		  prefix-icon='el-icon-user'
		  :style="{width: '100%'}"
        />
      </el-form-item>
      <el-form-item label="出生地点分类" prop="location">
        <el-select v-model="queryParams.location" placeholder="请选择出生地点分类" clearable size="small">
          <el-option
            v-for="dict in locationOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="接生人员" prop="doctor">
        <el-input
          v-model="queryParams.doctor"
          placeholder="请输入接生人员"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="接生机构名称" prop="hospital">
        <el-input
          v-model="queryParams.hospital"
          placeholder="请输入接生机构名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="签发时间" prop="today">
        <el-date-picker clearable size="small"
          v-model="queryParams.today"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择签发时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:baby:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:baby:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:baby:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:baby:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="babyList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="序号" align="center" prop="id" />
      <el-table-column label="姓名" align="center" prop="name" />
      <el-table-column label="性别" align="center" prop="sex" :formatter="sexFormat" />
      <el-table-column label="出生日期" align="center" prop="birth" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.birth, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="出生地" align="center" prop="address" />
      <el-table-column label="出生孕周" align="center" prop="weekNum" />
      <el-table-column label="健康状况" align="center" prop="status" :formatter="statusFormat" />
      <el-table-column label="体重" align="center" prop="weight" />
      <el-table-column label="体长" align="center" prop="height" />
      <el-table-column label="母亲姓名" align="center" prop="nameMother" />
      <el-table-column label="年龄" align="center" prop="ageMother" />
      <el-table-column label="国籍" align="center" prop="countryMother" />
      <el-table-column label="身份证号" align="center" prop="idMother" />
      <el-table-column label="父亲姓名" align="center" prop="nameFather" />
      <el-table-column label="年龄" align="center" prop="ageFather" />
      <el-table-column label="国籍" align="center" prop="countryFather" />
      <el-table-column label="身份证号" align="center" prop="idFather" />
      <el-table-column label="出生地点分类" align="center" prop="location" :formatter="locationFormat" />
      <el-table-column label="接生人员" align="center" prop="doctor" />
      <el-table-column label="接生机构名称" align="center" prop="hospital" />
      <el-table-column label="签发时间" align="center" prop="today" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.today, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:baby:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:baby:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改信息录入对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="form.sex" placeholder="请选择性别">
            <el-option
              v-for="dict in sexOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="出生日期" prop="birth">
          <el-date-picker clearable size="small"
            v-model="form.birth"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出生地" prop="address">
          <el-input v-model="form.address" placeholder="请输入出生地" />
        </el-form-item>
        <el-form-item label="出生孕周" prop="weekNum">
          <el-input v-model="form.weekNum" placeholder="请输入出生孕周" />
        </el-form-item>
        <el-form-item label="健康状况">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in statusOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="体重" prop="weight">
          <el-input> v-model="form.weight" placeholder="请输入体重"
          	<template slot="append">克</template>
          </el-input>
        </el-form-item>
        <el-form-item label="体长" prop="height">
          <el-input> v-model="form.height" placeholder="请输入体长"
            <template slot="append">厘米</template>
          </el-input>
        </el-form-item>
        <el-form-item label="母亲姓名" prop="nameMother">
          <el-input v-model="form.nameMother" placeholder="请输入母亲姓名" />
        </el-form-item>
        <el-form-item label="年龄" prop="ageMother">
          <el-input v-model="form.ageMother" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="国籍" prop="countryMother">
          <el-input v-model="form.countryMother" placeholder="请输入国籍" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idMother">
          <el-input v-model="form.idMother" placeholder="请输入身份证号"  :maxlength="18" show-word-limit />
        </el-form-item>
        <el-form-item label="父亲姓名" prop="nameFather">
          <el-input v-model="form.nameFather" placeholder="请输入父亲姓名" />
        </el-form-item>
        <el-form-item label="年龄" prop="ageFather">
          <el-input v-model="form.ageFather" placeholder="请输入年龄" />
        </el-form-item>
        <el-form-item label="国籍" prop="countryFather">
          <el-input v-model="form.countryFather" placeholder="请输入国籍" />
        </el-form-item>
        <el-form-item label="身份证号" prop="idFather">
          <el-input v-model="form.idFather" placeholder="请输入身份证号"  :maxlength="18" show-word-limit />
        </el-form-item>
        <el-form-item label="出生地点分类">
          <el-radio-group v-model="form.location">
            <el-radio
              v-for="dict in locationOptions"
              :key="dict.dictValue"
              :label="dict.dictValue"
            >{{dict.dictLabel}}</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="接生人员" prop="doctor">
          <el-input v-model="form.doctor" placeholder="请输入接生人员" />
        </el-form-item>
        <el-form-item label="接生机构名称" prop="hospital">
          <el-input v-model="form.hospital" placeholder="请输入接生机构名称" />
        </el-form-item>
        <el-form-item label="签发时间" prop="today">
          <el-date-picker clearable size="small"
            v-model="form.today"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择签发时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBaby, getBaby, delBaby, addBaby, updateBaby, exportBaby } from "@/api/system/baby";

export default {
  name: "Baby",
  components: {
  },
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: false,
      // 总条数
      total: 0,
      // 信息录入表格数据
      babyList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 性别字典
      sexOptions: [],
      // 健康状况字典
      statusOptions: [],
      // 出生地点分类字典
      locationOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        sex: null,
        birth: null,
        address: null,
        weekNum: null,
        status: null,
        weight: null,
        height: null,
        nameMother: null,
        ageMother: null,
        countryMother: null,
        idMother: null,
        nameFather: null,
        ageFather: null,
        countryFather: null,
        idFather: null,
        location: null,
        doctor: null,
        hospital: null,
        today: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
		idMother: [{
          required: true,
          message: '请输入身份证号',
          trigger: 'blur'
        }, {
          pattern: /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
          message: '身份证格式错误',
          trigger: 'blur'
        }],
		idFather: [{
          required: false,
          message: '请输入身份证号',
          trigger: 'blur'
        }, {
          pattern: /^[1-9]\d{5}(18|19|20|(3\d))\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/,
          message: '身份证格式错误',
          trigger: 'blur'
        }],
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_user_sex").then(response => {
      this.sexOptions = response.data;
    });
    this.getDicts("baby_state").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("baby_location").then(response => {
      this.locationOptions = response.data;
    });
  },
  methods: {
    /** 查询信息录入列表 */
    getList() {
      this.loading = true;
      listBaby(this.queryParams).then(response => {
        this.babyList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 性别字典翻译
    sexFormat(row, column) {
      return this.selectDictLabel(this.sexOptions, row.sex);
    },
    // 健康状况字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 出生地点分类字典翻译
    locationFormat(row, column) {
      return this.selectDictLabel(this.locationOptions, row.location);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        sex: null,
        birth: null,
        address: null,
        weekNum: null,
        status: "0",
        weight: null,
        height: null,
        nameMother: null,
        ageMother: null,
        countryMother: null,
        idMother: null,
        nameFather: null,
        ageFather: null,
        countryFather: null,
        idFather: null,
        location: "0",
        doctor: null,
        hospital: null,
        today: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加信息录入";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBaby(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改信息录入";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBaby(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBaby(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除信息录入编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delBaby(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        })
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有信息录入数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportBaby(queryParams);
        }).then(response => {
          this.download(response.msg);
        })
    }
  }
};
</script>
