<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :sm="24" :lg="12" style="padding-left: 20px">
        <h2>新生儿管理系统</h2>
<!--        <p>
          随着经济的发展，社会的进步，科学技术水平不断提高，计算机科学日渐成熟，
          计算机越来越深入到我们日常的工作学习及生活中，成为我们日常生活中不可
          缺少的辅助工具。其强大的功能已为人们深刻认识，它已进入人类社会的各个
          领域并发挥着越来越重要的作用。遂开发本新生儿管理系统。
        </p>-->
      </el-col>
    </el-row>

    <el-row :gutter="20">
      <el-col :sm="24" :lg="24" style="padding-left: 20px">
        <p>
              《出生医学证明》是证明婴儿出生状态，血亲关系的法定医学证明，是申报国籍、户籍,取得公民身份证号码的法定医学证明,
          是重要的法律证件,是“人生第一证”,具有唯一性和严肃性,任何人不得随意损毁利涂改,新生儿父母或监护人应妥善保管,不得倒卖、
          转让、出借。
        </p>
        <p>
          一、产妇入院实行实名制,产妇及其亲属办理入院手续时必须提供“有效身份证件一致的姓名和其他信息。若因产妇及家属提供的
          信息错误节成信息不一致者。必要时需提供法定鉴定机构出具的亲子关系鉴定书或系子关系声明公证书后方可办理《出生医学证明》。
        </p>
        <p>
          二、《出生医学证明》签发实行承诺制,新生儿父母提供的各项信息，一旦签字确认即认为是真实有效并承诺承担相应的法律责任。
        </p>
        <p>
          三、领证人需提交以下资料:
        </p>
        <p>
          1.新生儿需取好姓名,尽量避免无法打印的生僻字,使用《通用规有汉字表》的汉字。
        </p>
        <p style="margin-bottom: 0">
          2.填全的《出生医学证明》首次签发登记表(禁止涂改损坏)。注:父母亲信息中所填住址为户籍住址（如:身份证上的住址和户籍
          住址为目一个住址,就按身份证上的住址一字不差的填写,不能简写。如:身份证上的住址和户籍住址不是同一个住址,则按户口本
          住址填写)。
        </p>
        <p style="font-size: 3px;font-weight:bold">
          注：父母年龄需填写按年算的周岁年龄。(例:2020-1989=31岁)
        </p>
        <p>
          3.父母双方有效身份证原件及复印件(不能过期)。
        </p>
        <p>
          4.领证人如不是新生儿母亲,需提供新生儿母亲亲自签字授权的委抖书,双方(新生儿母亲和受委托人）在签名处按手印,受委托人
          需携带本人有效身份证原件及复印件。
        </p>
        <p style="font-size: 3px;font-weight:bold">
          注:《出生医学证明》首次签发登记表和委托书一定要用黑色碳素笔填写。
        </p>
        <p>
          四、《出生医学证明》签发后,领证人核对无误后签字, 并承担相应的法律责任。
        </p>
        <p>
          五、一定要及时办理《出生医学证明》,如新生儿出生超过30个工作日未办理的,办证时需再提供住院病历复印件1份;超过一年
          及以上未办理的,需提供住院病历复印件1份和法定机构出具的亲子鉴定书。
        </p>
        <p style="font-size: 3px;font-weight:bold">
          注:《出生医学证明》办理完毕后,不得涂改、塑封、折叠,折切副页
        </p>
      </el-col>
      <el-col>
<!--        <el-table v-loading="loading" :data="noticeList">
          <el-table-column label="公告" align="center" prop="noticeTitle" />

        </el-table>-->
        <!--<pagination
          v-show="total>0"
          :total="total"
          :page.sync="queryParams.pageNum"
          :limit.sync="queryParams.pageSize"
          @pagination="getList"
        />-->
      </el-col>
      <el-col class="notice">
        <el-button
          type="primary"
          plain
          size="default"
          @click="shownotice"
          v-hasPermi="['system:notice:list']"
        >公告</el-button>
      </el-col>
    </el-row>
  <el-dialog :title="title" :visible.sync="open" width="780px" append-to-body>
    <el-table v-loading="loading" :data="noticeList">
      <el-table-column label="公告" align="center" prop="noticeTitle" />

    </el-table>
    <div slot="footer" class="dialog-footer">
      <el-button @click="cancel">关  闭</el-button>
    </div>
  </el-dialog>
  </div>
</template>

<script>
  import { listNotice, getNotice } from "@/api/system/notice";
export default {
  name: "index",
  data() {
    return {
      // 版本号
      version: "3.4.0",
      // 遮罩层
      loading: true,
      // 弹出层标题
      //title: "公告",
      // 是否显示弹出层
      open: false,
      // 总条数
      total: 0,
      //通知数据
      noticeList: [],
      // 类型数据字典
      statusOptions: [],
      // 状态数据字典
      typeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        noticeTitle: undefined,
        createBy: undefined,
        status: undefined
      },
      // 表单参数
      form: {},
    };
  },
  created() {
    this.getList();
    this.getDicts("sys_notice_status").then(response => {
      this.statusOptions = response.data;
    });
    this.getDicts("sys_notice_type").then(response => {
      this.typeOptions = response.data;
    });
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },

    getList() {
      this.loading = true;
      listNotice(this.queryParams).then(response => {
        this.noticeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 公告状态字典翻译
    statusFormat(row, column) {
      return this.selectDictLabel(this.statusOptions, row.status);
    },
    // 公告状态字典翻译
    typeFormat(row, column) {
      return this.selectDictLabel(this.typeOptions, row.noticeType);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    /** 显示公告 */
    shownotice() {
      //this.reset();
      this.open = true;
      //this.title = "";
    },
  },
};

</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;
    font-size: 15px;

    b {
      font-weight: 700;
    }
  }


  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
  .notice {
    position: absolute;
    left: 90%;
    bottom: 0;
    border-radius: 60px;
  }

}
</style>

