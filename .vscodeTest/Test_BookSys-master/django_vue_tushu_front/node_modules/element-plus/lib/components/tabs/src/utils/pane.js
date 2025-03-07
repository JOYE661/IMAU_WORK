'use strict';

Object.defineProperty(exports, '__esModule', { value: true });

require('../../../../utils/index.js');
var vnode = require('../../../../utils/vue/vnode.js');
var vue = require('vue');

const getTabPanes = (vm) => {
  const nodes = vnode.flattedChildren(vm.subTree);
  return nodes.filter((n) => {
    var _a;
    return vue.isVNode(n) && ((_a = n.type) == null ? void 0 : _a.name) === "ElTabPane" && !!n.component;
  });
};
const getOrderedPanes = (vm, panes) => {
  const nodes = getTabPanes(vm);
  const uids = nodes.map((n) => n.component.uid);
  return uids.map((uid) => panes[uid]).filter((p) => !!p);
};

exports.getOrderedPanes = getOrderedPanes;
exports.getTabPanes = getTabPanes;
//# sourceMappingURL=pane.js.map
